package com.mediway.hos.srm.business.center.serviceimpl.pubmed;

import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PubmedSaxHandler extends DefaultHandler {

    private List<SrmPubmedPaper> papers = new ArrayList<>();
    private SrmPubmedPaper currentPaper;

    // PMID
    private boolean inPMID = false;

    // Title
    private boolean inArticleTitle = false;

    // Journal
    private boolean inJournalTitle = false;

    // Authors
    private boolean inAuthor = false;
    private boolean inLastName = false;
    private boolean inForeName = false;
    private StringBuilder currentLastName = new StringBuilder();
    private StringBuilder currentForeName = new StringBuilder();
    private List<String> currentAuthors = new ArrayList<>();

    // Abstract
    private boolean inAbstract = false;
    private boolean inAbstractText = false;
    private StringBuilder currentAbstract = new StringBuilder();
    private StringBuilder currentAbstractLabel = new StringBuilder();
    private StringBuilder currentAbstractText = new StringBuilder();

    // ArticleId (DOI, PMCID)
    private boolean inArticleId = false;
    private String currentIdType = "";
    private StringBuilder articleIdText = new StringBuilder();

    // PubDate
    private boolean inPubMedPubDate = false;
    private boolean inJournalPubDate = false;
    private boolean inYear = false;
    private boolean inMonth = false;
    private boolean inDay = false;
    private StringBuilder year = new StringBuilder();
    private StringBuilder month = new StringBuilder();
    private StringBuilder day = new StringBuilder();
    private boolean pubDateCaptured = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "PubmedArticle":
                currentPaper = new SrmPubmedPaper();
                currentAbstract.setLength(0);
                currentAuthors.clear();
                pubDateCaptured = false;
                break;

            case "PMID":
                inPMID = true;
                break;

            case "ArticleTitle":
                inArticleTitle = true;
                break;

            case "Title":
                if (!inArticleTitle) {
                    inJournalTitle = true;
                }
                break;

            case "Author":
                inAuthor = true;
                currentLastName.setLength(0);
                currentForeName.setLength(0);
                break;

            case "LastName":
                if (inAuthor) {
                    inLastName = true;
                    currentLastName.setLength(0);
                }
                break;

            case "ForeName":
                if (inAuthor) {
                    inForeName = true;
                    currentForeName.setLength(0);
                }
                break;

            case "Abstract":
                inAbstract = true;
                break;

            case "AbstractText":
                if (inAbstract) {
                    inAbstractText = true;
                    currentAbstractText.setLength(0);
                    currentAbstractLabel.setLength(0);
                    String label = attributes.getValue("Label");
                    if (label != null && !label.trim().isEmpty()) {
                        currentAbstractLabel.append(label.trim());
                    }
                }
                break;

            case "ArticleId":
                inArticleId = true;
                currentIdType = attributes.getValue("IdType");
                articleIdText.setLength(0);
                break;

            case "PubMedPubDate":
                String pubStatus = attributes.getValue("PubStatus");
                if ("pubmed".equals(pubStatus) && !pubDateCaptured) {
                    inPubMedPubDate = true;
                    resetDateBuffers();
                }
                break;

            case "PubDate":
                if (!pubDateCaptured) {
                    inJournalPubDate = true;
                    resetDateBuffers();
                }
                break;

            case "Year":
                if (inPubMedPubDate || inJournalPubDate) {
                    inYear = true;
                }
                break;

            case "Month":
                if (inPubMedPubDate || inJournalPubDate) {
                    inMonth = true;
                }
                break;

            case "Day":
                if (inPubMedPubDate || inJournalPubDate) {
                    inDay = true;
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length);

        if (inPMID) {
            currentPaper.setPmid(text.trim());
        } else if (inArticleTitle) {
            currentPaper.setTitle(text.trim());
        } else if (inJournalTitle) {
            currentPaper.setJournal(text.trim());
        } else if (inLastName) {
            currentLastName.append(text);
        } else if (inForeName) {
            currentForeName.append(text);
        } else if (inAbstractText) {
            currentAbstractText.append(text);
        } else if (inYear) {
            year.append(text);
        } else if (inMonth) {
            month.append(text);
        } else if (inDay) {
            day.append(text);
        } else if (inArticleId) {
            articleIdText.append(text);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "PMID":
                inPMID = false;
                break;

            case "ArticleTitle":
                inArticleTitle = false;
                break;

            case "Title":
                inJournalTitle = false;
                break;

            case "LastName":
                inLastName = false;
                break;

            case "ForeName":
                inForeName = false;
                break;

            case "Author":
                inAuthor = false;
                String lastName = currentLastName.toString().trim();
                String foreName = currentForeName.toString().trim();
                if (!lastName.isEmpty() || !foreName.isEmpty()) {
                    String author = lastName;
                    if (!foreName.isEmpty()) {
                        author += " " + foreName;
                    }
                    currentAuthors.add(author.trim());
                }
                break;

            case "AbstractText":
                if (inAbstractText) {
                    inAbstractText = false;
                    String text = currentAbstractText.toString().trim();
                    if (!text.isEmpty()) {
                        String paragraph;
                        if (currentAbstractLabel.length() > 0) {
                            paragraph = "[" + currentAbstractLabel.toString() + "] " + text;
                        } else {
                            paragraph = text;
                        }
                        if (currentAbstract.length() > 0) {
                            currentAbstract.append("\n\n");
                        }
                        currentAbstract.append(paragraph);
                    }
                }
                break;

            case "Abstract":
                inAbstract = false;
                break;

            case "ArticleId":
                inArticleId = false;
                String idValue = articleIdText.toString().trim();
                if ("pmc".equals(currentIdType)) {
                    currentPaper.setPmcid(idValue);
                } else if ("doi".equals(currentIdType)) {
                    currentPaper.setDoi(idValue);
                }
                break;

            case "Year":
                inYear = false;
                break;

            case "Month":
                inMonth = false;
                break;

            case "Day":
                inDay = false;
                break;

            case "PubMedPubDate":
                if (inPubMedPubDate) {
                    capturePubDate();
                    inPubMedPubDate = false;
                }
                break;

            case "PubDate":
                if (inJournalPubDate) {
                    capturePubDate();
                    inJournalPubDate = false;
                }
                break;

            case "PubmedArticle":
                currentPaper.setIntro(currentAbstract.toString());
                currentPaper.setAuthor(String.join("; ", currentAuthors));
                papers.add(currentPaper);
                break;
        }
    }

    private void resetDateBuffers() {
        year.setLength(0);
        month.setLength(0);
        day.setLength(0);
    }

    private void capturePubDate() {
        if (pubDateCaptured) return;

        String y = year.toString().trim();
        String m = month.toString().trim();
        String d = day.toString().trim();

        if (y.isEmpty()) return;

        if (!m.matches("\\d{1,2}") && !m.isEmpty()) {
            m = convertMonthToNumber(m);
        }

        try {
            if (!m.isEmpty() && !d.isEmpty()) {
                LocalDate date = LocalDate.of(
                        Integer.parseInt(y),
                        Integer.parseInt(m),
                        Integer.parseInt(d)
                );
                currentPaper.setPubDate(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
            } else if (!m.isEmpty()) {
                LocalDate date = LocalDate.of(Integer.parseInt(y), Integer.parseInt(m), 1);
                currentPaper.setPubDate(date.format(DateTimeFormatter.ofPattern("yyyy-MM")) + "-01");
            } else {
                currentPaper.setPubDate(y + "-01-01");
            }
            pubDateCaptured = true;
        } catch (Exception e) {
            currentPaper.setPubDate(y + "-01-01");
            pubDateCaptured = true;
        }
    }

    private String convertMonthToNumber(String monthStr) {
        String m = monthStr.toLowerCase().trim();
        switch (m) {
            case "jan": case "january": return "1";
            case "feb": case "february": return "2";
            case "mar": case "march": return "3";
            case "apr": case "april": return "4";
            case "may": return "5";
            case "jun": case "june": return "6";
            case "jul": case "july": return "7";
            case "aug": case "august": return "8";
            case "sep": case "september": return "9";
            case "oct": case "october": return "10";
            case "nov": case "november": return "11";
            case "dec": case "december": return "12";
            default:
                return m.matches("\\d+") ? m : "1";
        }
    }

    public List<SrmPubmedPaper> getPapers() {
        return papers;
    }
}