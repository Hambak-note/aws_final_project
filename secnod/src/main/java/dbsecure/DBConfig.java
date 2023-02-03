package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration //내가 설정 클래스입니다.
@EnableEncryptableProperties //현재 정보를 application.properties 파일에서 사용 가능
public class DBConfig {

	@Bean("jasyptEncryptor") //메소드 리턴객체 주입
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        //깃헙에 드러나면 안되어서 환경변수로 처리해야 함
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println("===DBConfig 출력===");
        System.out.println
        (encryptor.decrypt("moJ26ggbkZb7WoTBN2h178O7ql3wQXbHC0YCuxpdLqo="));
        System.out.println
        (encryptor.decrypt("JrZ6tL7FaWMptTKps3cc3kCt8Ce1fvYqakCH9fiBZwMBBH03PY9Yk4UMmXcnzoT/OzRAwOlrHCtWZQfPnASolgDSBSIzLhYVv57fLxnR8LNJLLHfNfFKhUllSmRlRNnAlkLoVs+T38c="));
        System.out.println(encryptor.decrypt("SQlgkmN2hyL23kWpHEBJ0ANC/wCEYPM8"));
        System.out.println(encryptor.decrypt("y5tuSFbWXYnsQ/X1fNMn20564HgumMp0"));
        
        
        return encryptor;
	}
	
}
