package ir.online.shop.domain.service;


import io.qoop.filter.bean.api.UseCaseService;

@UseCaseService
public class CdnStorageServiceImpl implements CdnStorageService {

    @Override
    public String upload(byte[] bytes, String originalFilename, String contentType) {
        return getRandomUrl();
    }

    private String getRandomUrl() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int count = 20 + ((int) (Math.random() * alphabet.length()));
        String result = "";
        for (int i = 0; i < count; i++) {
            result += alphabet.charAt(((int) (Math.random() * alphabet.length())));
        }
        return result;
    }


}
