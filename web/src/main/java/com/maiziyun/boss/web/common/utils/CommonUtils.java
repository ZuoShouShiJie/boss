package com.maiziyun.boss.web.common.utils;

import com.maiziyun.acs.facade.enums.*;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.vo.OperatorVo;
import com.maiziyun.boss.facade.product.model.HotFundModifyRequest;
import com.maiziyun.boss.web.vo.HotFundRequest;
import com.maiziyun.boss.web.vo.HotFundRequestVo;
import com.maiziyun.boss.web.vo.StateListVo;
import com.maiziyun.boss.web.vo.UploadImgsForm;
import com.maiziyun.cms.facade.PositionManagerService;
import com.maiziyun.cms.facade.emuns.CmsChannelCode;
import com.maiziyun.cms.facade.emuns.CmsStatus;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.mdc.facade.emuns.MdcOnLineCode;
import com.maiziyun.mdc.facade.emuns.MdcSourceCode;
import com.maiziyun.mdc.facade.emuns.MdcTypeCode;
import com.maiziyun.product.facade.enums.EffectFlag;
import com.solar.framework.core.base.AbstractPagedResponse;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by len.song on 2016/11/28.
 */
public class CommonUtils {
    /**
     * 判断请求是否是ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isJaxRequest(HttpServletRequest request) {

        String headerType = request.getHeader("Access-Control-Request-Headers");

        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) ||
                "BOSSAJAX".equalsIgnoreCase(request.getHeader("boss_ajax_header")) ||
                "X-Requested-With".equalsIgnoreCase(headerType)) {
            return true;
        }
        return false;
    }

    /**
     * 分页类型的map封装
     *
     * @param response
     * @return
     */
    public static Map<String, Object> getPageMap(AbstractPagedResponse<?> response) {
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("rows", response.getDatas());
        results.put("total", response.getDatas() == null ? null : response.getTotal());
        return results;
    }


    public static String genToken(OperatorVo vo) {
        String bossCode = MyServiceCode.Boss.code();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsss");
        String s1 = sdf.format(date);
        Integer a = 1000 + vo.getOperatorId();
        //系统号+日期+1000+操作员id
        String b = bossCode + s1 + a.toString();
        return b;
    }

    public static List<HotFundModifyRequest> getLabel(List<HotFundRequestVo> hotLists, String type) {

        List<HotFundRequest> lists = new ArrayList<HotFundRequest>();
        for (HotFundRequestVo vo : hotLists) {
            HotFundRequest request = new HotFundRequest();
            request.setId(vo.getId());
            List<String> labels = vo.getLabels();
            if (labels != null &&labels.size()> 0) {
                StringBuilder result = new StringBuilder();
                boolean first = true;
                //第一个前面不拼接","
                for (int i=0;i<labels.size();i++){
                    String s = labels.get(i);
                    if (StringUtils.isNotBlank(s)){
                        if (first) {
                            first = false;
                        } else {
                            result.append(",");
                        }
                        result.append(s);
                    }

                }
                String label = result.toString();
                request.setLabel(label);
            }
            request.setType(type);
            lists.add(request);
        }
        List<HotFundModifyRequest> list = new ArrayList<HotFundModifyRequest>();
        if (lists != null && lists.size() > 0) {

            for (int i = 0; i < lists.size(); i++) {
                HotFundRequest hot = lists.get(i);
                HotFundModifyRequest vo = new HotFundModifyRequest();
                vo.setId(hot.getId());
                vo.setLabel(hot.getLabel());
                vo.setType(hot.getType());
                list.add(vo);
            }
        }
        return list;
    }

    /**
     * 热门专题文件上传
     *
     * @param path
     * @param fileName
     * @param mFile
     * @return
     * @throws IOException
     */
    public static String uploadFileHot(String path, String fileName, String suffix, MultipartFile mFile)
            throws IOException {
        if (!mFile.isEmpty()) {
            long a = mFile.getSize();
            if (mFile.getSize() > 1024 * 1024) {
                throw new BizException(BossBizCode.PicFileSize, "上传图片大于1M,不能上传");
            }
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = path + fileName + suffix;
        File pic = new File(filePath);
        InputStream stream = mFile.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(pic);
        try {
            int byteCount;
            byte[] bytes = new byte[1024];
            while ((byteCount = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, byteCount);
            }
            outputStream.flush();
        } finally {
            outputStream.close();
            stream.close();
        }
        return filePath;
    }


    /**
     * 文件上传
     *
     * @param path
     * @param fileName
     * @param mFile
     * @return
     * @throws IOException
     */
    public static String uploadFile(String path, String fileName, String suffix, MultipartFile mFile)
            throws IOException {
        if (!mFile.isEmpty()) {
            long a = mFile.getSize();
            if (mFile.getSize() > 300 * 1024) {
                throw new BizException(BossBizCode.PicFileSize, "上传图片大于300KB,不能上传");
            }
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = path + fileName + suffix;
        File pic = new File(filePath);
        InputStream stream = mFile.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(pic);
        try {
            int byteCount;
            byte[] bytes = new byte[1024];
            while ((byteCount = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, byteCount);
            }
            outputStream.flush();
        } finally {
            outputStream.close();
            stream.close();
        }
        return filePath;
    }

    public static String genRand(String str) {
        String bossCode = MyServiceCode.Boss.code();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsss");
        String s1 = sdf.format(date);
        String b = str + bossCode + s1;
        return b;
    }

    public static String getSuffxi(MultipartFile coverImg) {
        String name = coverImg.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));
        return suffix;
    }

    public static List<StateListVo> getStateList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(CmsStatus.ONLINE_STATUS.name());
        vo.setName(CmsStatus.ONLINE_STATUS.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(CmsStatus.OFFLINE_STATUS.name());
        vo.setName(CmsStatus.OFFLINE_STATUS.desc());
        list.add(vo);
        return list;

    }

    public static List<StateListVo> getChanList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("07");//MdcSourceCode.MDC_Channel_All.code()
        vo.setName("全部通道");
        list.add(vo);
        vo = new StateListVo();
        vo.setId("03");
        vo.setName("IOS");
        list.add(vo);
        vo = new StateListVo();
        vo.setId("04");
        vo.setName("Android");
        list.add(vo);
        return list;

    }
//cms
    public static List<StateListVo> getChanListCms() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("07");//CmsChannelCode.All.code()
        vo.setName("全部通道");
        list.add(vo);
        vo = new StateListVo();
        vo.setId("03");
        vo.setName("IOS");
        list.add(vo);
        vo = new StateListVo();
        vo.setId("04");
        vo.setName("Android");
        list.add(vo);
        return list;

    }


    public static List<StateListVo> getTypeList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部类型");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(MdcTypeCode.News_Notice.code());
        vo.setName(MdcTypeCode.News_Notice.name());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(MdcTypeCode.Weal_Notice.code());
        vo.setName(MdcTypeCode.Weal_Notice.name());
        list.add(vo);
        return list;
    }

    //状态
    public static List<StateListVo> getStatusList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskStatus.Invalid.name());
        vo.setName(TaskStatus.Invalid.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskStatus.Valid.name());
        vo.setName(TaskStatus.Valid.desc());
        list.add(vo);
        return list;
    }

    //任务行为
    public static List<StateListVo> getTaskActList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部行为");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.CutWheat.name());
        vo.setName(TaskAction.CutWheat.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.Invest.name());
        vo.setName(TaskAction.Invest.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.Login.name());
        vo.setName(TaskAction.Login.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.CornfieldShare.name());
        vo.setName(TaskAction.CornfieldShare.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.BindBankCard.name());
        vo.setName(TaskAction.BindBankCard.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.BindEstate.name());
        vo.setName(TaskAction.BindEstate.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskAction.BindVehicle.name());
        vo.setName(TaskAction.BindVehicle.desc());
        list.add(vo);
        return list;
    }

    //任务类型
    public static List<StateListVo> getTaskTypeList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskType.SingleTask.name());
        vo.setName(TaskType.SingleTask.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskType.DailyTask.name());
        vo.setName(TaskType.DailyTask.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskType.CumulativeTask.name());
        vo.setName(TaskType.CumulativeTask.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(TaskType.ContinuousTask.name());
        vo.setName(TaskType.ContinuousTask.desc());
        list.add(vo);
        return list;
    }

    //投资范围
    public static List<StateListVo> getInveScopeList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部产品");
        list.add(vo);
        vo = new StateListVo();
        vo.setId(InvestScope.Maisuibao.name());
        vo.setName(InvestScope.Maisuibao.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(InvestScope.TimeDepositProducts.name());
        vo.setName(InvestScope.TimeDepositProducts.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(InvestScope.FundProducts.name());
        vo.setName(InvestScope.FundProducts.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(InvestScope.CombinationProducts.name());
        vo.setName(InvestScope.CombinationProducts.desc());
        list.add(vo);

        return list;


    }

    //投资条件
    public static List<StateListVo> getInveConditListList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId(InvestCondition.Amount.name());
        vo.setName(InvestCondition.Amount.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(InvestCondition.Times.name());
        vo.setName(InvestCondition.Times.desc());
        list.add(vo);
        return list;

    }

    //前端可见
    public static List<StateListVo> getFrontVisibleList() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId(FrontVisible.No.name());
        vo.setName(FrontVisible.No.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(FrontVisible.Yes.name());
        vo.setName(FrontVisible.Yes.desc());
        list.add(vo);
        return list;

    }


    //组合列表,是否上下架
    public static List<StateListVo> getEffectFlag() {
        List<StateListVo> list = new ArrayList<>();
        StateListVo vo = new StateListVo();
        vo.setId(EffectFlag.On.code());
        vo.setName(EffectFlag.On.desc());
        list.add(vo);
        vo = new StateListVo();
        vo.setId(EffectFlag.Off.code());
        vo.setName(EffectFlag.Off.desc());
        list.add(vo);
        return list;

    }

    public static List<MultipartFile> convertRequest(UploadImgsForm form) {
        List<MultipartFile> fileList = new ArrayList<>();
        MultipartFile[] files = form.getFieldName();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            fileList.add(file);
        }
        return fileList;
    }

}
