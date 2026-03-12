//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mediway.hos.generator.util;

import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

public class PackageHelper {
    public PackageHelper() {
    }

    public static String[] convertTypeAliasesPackage(String typeAliasesPackage) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        String pkg = "classpath*:" + ClassUtils.convertClassNameToResourcePath(typeAliasesPackage) + "/*.class";

        try {
            Set<String> set = new HashSet();
            Resource[] resources = resolver.getResources(pkg);
            if (resources != null && resources.length > 0) {
                Resource[] var7 = resources;
                int var8 = resources.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    Resource resource = var7[var9];
                    if (resource.isReadable()) {
                        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        set.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                    }
                }
            }

            return !set.isEmpty() ? set.toArray(new String[0]) : new String[0];
        } catch (Exception var11) {
            throw ExceptionUtils.mpe("not find typeAliasesPackage: %s", var11, pkg);
        }
    }

    public static Set<Class> scanTypePackage(String typePackage) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        String pkg = "classpath*:" + ClassUtils.convertClassNameToResourcePath(typePackage) + "/*.class";

        try {
            Set<Class> set = new HashSet();
            Resource[] resources = resolver.getResources(pkg);
            if (resources != null && resources.length > 0) {
                Resource[] var7 = resources;
                int var8 = resources.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    Resource resource = var7[var9];
                    if (resource.isReadable()) {
                        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        set.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                    }
                }
            }

            return set;
        } catch (Exception var11) {
            throw ExceptionUtils.mpe("not find scanTypePackage: %s", var11, pkg);
        }
    }

    public static void mkDir(File file) {
        if (file.getParentFile().exists()) {
            file.mkdir();
        } else {
            mkDir(file.getParentFile());
            file.mkdir();
        }

    }
}
