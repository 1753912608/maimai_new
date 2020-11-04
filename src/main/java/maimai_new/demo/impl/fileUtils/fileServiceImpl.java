package maimai_new.demo.impl.fileUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class fileServiceImpl {


    /**
     *
     * @param fileSrc
     * @param file
     * 存储单个文件
     */
    public void saveOneFile(String fileSrc, MultipartFile file)
    throws IOException {
        fileSrc="file/"+file.getOriginalFilename();
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File("src/main/resources/static/"+fileSrc));
    }
}
