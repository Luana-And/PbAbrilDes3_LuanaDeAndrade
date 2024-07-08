package br.com.bancoamericano.mscustomer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.Base64;
import java.util.UUID;

@Service
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadImage(String base64Image) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
        String fileName = UUID.randomUUID().toString() + ".jpg";

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(decodedBytes));

        // Construct the URL for the uploaded object
        String imageUrl = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(fileName)).toExternalForm();

        return imageUrl;
    }
}
