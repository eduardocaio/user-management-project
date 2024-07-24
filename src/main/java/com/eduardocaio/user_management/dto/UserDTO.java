package com.eduardocaio.user_management.dto;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.entities.UserEntity;
import com.eduardocaio.user_management.entities.enums.StatusUser;

public class UserDTO {

        private Long id;
        private String name;
        private String login;
        private String password;
        private String email;
        private StatusUser status;

        public UserDTO(UserEntity user){
            BeanUtils.copyProperties(user, this);
        }

        public UserDTO(){

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public StatusUser getStatus() {
            return status;
        }

        public void setStatus(StatusUser status) {
            this.status = status;
        }

        

        

}
