import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ecryptalgo {
    public static void main(String[] args){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("arun"));
    }
}
