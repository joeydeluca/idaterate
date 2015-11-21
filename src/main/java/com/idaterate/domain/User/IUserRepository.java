package com.idaterate.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public interface IUserRepository extends JpaRepository<IUserRepository.User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);

    /**
     * Created by Joe Deluca on 05/11/2015.
     */
    @Entity
    class User {
        @javax.persistence.Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long Id;
        private String email;
        private String username;
        private String password;
        private String city;
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate;

        @PrePersist
        protected void onCreate() {
            createdDate = new Date();
        }

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Date getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }
    }
}
