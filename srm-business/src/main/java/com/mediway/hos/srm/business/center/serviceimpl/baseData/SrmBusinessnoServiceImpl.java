package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmBusinessno;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmBusinessnoMapper;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.LockUtil;
import com.mediway.hos.srm.business.center.utils.LockUtilFactory;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 单号生成 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-14
 */
@Service
public class SrmBusinessnoServiceImpl extends BaseServiceImpl<SrmBusinessnoMapper, SrmBusinessno> implements SrmBusinessnoService {
    @Autowired
    private SrmBusinessnoMapper srmBusinessnoMapper;
    private final Lock lock = new ReentrantLock();
    private final LockUtil lockUtil=LockUtilFactory.getLockUtil("P001", 1000L, 24 * 60 * 60 * 1000L);
    @Override
    public synchronized String getBusinessNo(String type,int size,String prefix) {
        QueryWrapper<SrmBusinessno> srmBusinessnoQueryWrapper=new QueryWrapper<>();
        srmBusinessnoQueryWrapper.eq("type",type);
        List<SrmBusinessno> businessnoList=srmBusinessnoMapper.selectList(srmBusinessnoQueryWrapper);
        int number=0;
        if(businessnoList.isEmpty()){
            // 插入1，并返回1
            SrmBusinessno srmBusinessno=new SrmBusinessno();
            srmBusinessno.setType(type);
            srmBusinessno.setCurrentno(1);
            this.save(srmBusinessno);
            number=1;
        }else{
            SrmBusinessno businessno=srmBusinessnoMapper.getSrmBusinessno(type);
            int currentNo=businessno.getCurrentno();
            SrmBusinessno srmBusinessno=new SrmBusinessno();
            srmBusinessno.setId(businessno.getId());
            srmBusinessno.setType(type);
            srmBusinessno.setCurrentno(currentNo+1);
            this.saveOrUpdate(srmBusinessno);
            number= currentNo+1;
        }
        if(prefix!=null){
            return prefix+StringUtils.leftPad(String.valueOf(number), size, "0");
        }else{
            return StringUtils.leftPad(String.valueOf(number), size, "0");
        }

    }

    @Override
    public String test(String type, int size, String prefix) {

        //LockUtil lockUtil=LockUtilFactory.getLockUtil("P001", 1000L, 24 * 60 * 60 * 1000L);
        lockUtil.lock("1111||1||1");
        //lock.lock();
        try{
            QueryWrapper<SrmBusinessno> srmBusinessnoQueryWrapper=new QueryWrapper<>();
            srmBusinessnoQueryWrapper.eq("type",type);
            List<SrmBusinessno> businessnoList=srmBusinessnoMapper.selectList(srmBusinessnoQueryWrapper);
            int number=0;
            if(businessnoList.isEmpty()){
                // 插入1，并返回1
                SrmBusinessno srmBusinessno=new SrmBusinessno();
                srmBusinessno.setType(type);
                srmBusinessno.setCurrentno(1);
                this.save(srmBusinessno);
                number=1;
            }else{
                SrmBusinessno businessno=srmBusinessnoMapper.getSrmBusinessno(type);
                int currentNo=businessno.getCurrentno();
                SrmBusinessno srmBusinessno=new SrmBusinessno();
                srmBusinessno.setId(businessno.getId());
                srmBusinessno.setType(type);
                srmBusinessno.setCurrentno(currentNo+1);
                this.saveOrUpdate(srmBusinessno);
                number= currentNo+1;
            }
            if(prefix!=null){
                return prefix+StringUtils.leftPad(String.valueOf(number), size, "0");
            }else{
                return StringUtils.leftPad(String.valueOf(number), size, "0");
            }
        }finally {
            //lock.unlock();
            lockUtil.unLock("P001-1");
        }
    }
}
