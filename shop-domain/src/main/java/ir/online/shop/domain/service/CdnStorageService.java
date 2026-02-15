package ir.online.shop.domain.service;


public interface CdnStorageService {
    String upload(byte[] bytes, String originalFilename, String contentType);
}
