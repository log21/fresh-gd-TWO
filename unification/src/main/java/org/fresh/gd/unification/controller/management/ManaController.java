package org.fresh.gd.unification.controller.management;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.management.GdStoreDTO;
import org.fresh.gd.commons.consts.utils.OSSClientUtil;
import org.fresh.gd.unification.fegin.management.ManaFeginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @DATA 2019-04-17 15:15
 * @Author 张国伟  WeChat:17630376104
 * @Description
 */
@Api(description = "添加门店信息")
@Slf4j
@RestController
@RequestMapping("/unification")
public class ManaController {
    @Autowired
    ManaFeginService manaFeginService;



    @PostMapping("/imageAdd")
    public ResponseData<Integer> imageAdd(@RequestBody RequestData<GdStoreDTO> requestData) {
        MultipartFile multipartFile = requestData.getData().getMultipartFile();
        OSSClientUtil ossClient = new OSSClientUtil();
        try {
            if (multipartFile == null || multipartFile.getSize() <= 0) {
                log.info("图片不能为空");
            }
            String name = ossClient.uploadImg2Oss(multipartFile);
            String imgUrl = ossClient.getImgUrl(name);
            requestData.getData().setStoreImagesUri(imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manaFeginService.inserStore(requestData.getData());
    }

    @PostMapping("/selStorAndImage")
    public ResponseData<List<GdStoreDTO>> selStorAndImage(@RequestBody GdStoreDTO manageStoreDTO) {
        ResponseData<List<GdStoreDTO>> listResponseData = manaFeginService.selStroreByName(manageStoreDTO);
        List<GdStoreDTO> data = listResponseData.getData();
        return listResponseData;
    }

    @PostMapping("/GdStoreQueryAll")
    public ResponseData<List<GdStoreDTO>> QueryAll() {
        return manaFeginService.QueryAll();
    }
}
