//package ir.shop.online.core.infrastructure.persistence.repository.memory;
//
//import ir.shop.online.core.domain.model.otp.OTP;
//import ir.shop.online.core.domain.repository.memory.OtpRepository;
//import lombok.RequiredArgsConstructor;
//
//import java.util.concurrent.TimeUnit;
//
//@RequiredArgsConstructor
//public class OtpRepositoryMemoryAdapter implements OtpRepository {
//
//
//    @Override
//    public boolean existsByIdentifier(String identifier) {
//        String cooldownKey = OTP_COOLDOWN_PREFIX + identifier;
//        return redisTemplate.hasKey(cooldownKey);
//    }
//
//    @Override
//    public OTP findByIdentifier(String identifier) {
//        String key = OTP_PREFIX + identifier;
//        return redisTemplate.opsForValue().get(key);
//    }
//
//    @Override
//    public void saveByIdentifier(String identifier, OTP otp, long expirationTime, TimeUnit expirationTimeUnit) {
//        String key = OTP_PREFIX + identifier;
//        redisTemplate.opsForValue().set(key, otp, expirationTime, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void saveCooldown(String identifier, OTP otp, long resendCooldown, TimeUnit expirationTimeUnit) {
//        String cooldownKey = OTP_COOLDOWN_PREFIX + identifier;
//        redisTemplate.opsForValue().set(
//                cooldownKey,
//                otp,
//                resendCooldown,
//                TimeUnit.SECONDS
//        );
//    }
//
//    @Override
//    public void deleteByIdentifier(String identifier) {
//        String oldKey = OTP_PREFIX + identifier;
//        redisTemplate.delete(oldKey);
//    }
//
//    @Override
//    public long getExpireByIdentifier(String identifier) {
//        String key = OTP_PREFIX + identifier;
//        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
//    }
//}
