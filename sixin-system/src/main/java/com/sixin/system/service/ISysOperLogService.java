package com.sixin.system.service;

import java.util.List;

import com.sixin.common.utils.PageData;
import com.sixin.system.domain.SysOperLog;

/**
 * 操作日志 服务层
 * 
 * @author sixin
 */
public interface ISysOperLogService
{
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 批量删除系统操作日志
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteOperLogByIds(String ids);

    /**
     * 查询操作日志详细
     * 
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    public void cleanOperLog();

    /**
     * 获取最近的操作记录传给前端
     *
     * @return 结果
     */
    public List<PageData> selectOperLogforIndex();

    /**
     * 获取最近一个月操作次数最多的五个人名单
     *
     * @return 结果
     */
    public List<PageData> CountLogDescForMonth();
}
