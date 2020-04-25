package org.woodwhales.ncov;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @projectName: 2019-nCoV
 * @author: woodwhales
 * @date: 20.2.23 21:32
 * @description:
 */
public class PasswordTest {
    public static void main(String[] args) {
        // $2a$10$3Rsjzi7x8jgUkebqRtU/recNfesKAnpAb2oiCtjFLynbMn7c7BmZa
        System.out.println(new BCryptPasswordEncoder().encode("user"));
        // $2a$10$OCu8Bbm5f8h.TdMyBHUtKuij8rGB8iu0qgZUjlvqFlDuYcru.JE3.
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
