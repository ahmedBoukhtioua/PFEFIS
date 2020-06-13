package com.pfe.RCV.payload.request;

public class LoginRequest {
        private  String eNumber ;
        private  String password ;

        public LoginRequest(String eNumber, String password) {
            eNumber = eNumber;
            this.password = password;
        }

        public LoginRequest() {
        }

        public String getUsername() {
            return eNumber;
        }
    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
