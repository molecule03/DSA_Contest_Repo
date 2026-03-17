package LLD.Design_Patterns.Creational;

import lombok.Getter;

@Getter
public class Builder {

    public static void main(String[] args) {
        User newUser = User.builder()
                            .name("lavesh")
                            .surname("salaskar")
                            .city("mumbai")
//                            .email("xyz@google.com")
                            .build();
    }

    static class User{
        private String name;
        private String surname;
        private String email;
        private String phoneNumber;
        private int height;
        private int weight;
        private String city;

        private User(UserBuilder userBuilder){
            this.name = userBuilder.name;
            this.surname = userBuilder.surname;
            this.email = userBuilder.email;
            this.phoneNumber = userBuilder.phoneNumber;
            this.height = userBuilder.height;
            this.weight = userBuilder.weight;
            this.city = userBuilder.city;
        }
        public static UserBuilder builder(){
            return new UserBuilder();
        }

        static class UserBuilder{
            private String name;
            private String surname;
            private String email;
            private String phoneNumber;
            private int height;
            private int weight;
            private String city;

            public UserBuilder name(String name){
                this.name = name;
                return this;
            }
            public UserBuilder surname(String surname){
                this.surname = surname;
                return this;
            }
            public UserBuilder email(String email){
                this.email = email;
                return this;
            }
            public UserBuilder phoneNumber(String phoneNumber){
                this.phoneNumber = phoneNumber;
                return this;
            }
            public UserBuilder height(int height){
                this.height = height;
                return this;
            }
            public UserBuilder weight(int weight){
                this.weight = weight;
                return this;
            }
            public UserBuilder city(String city){
                this.city = city;
                return this;
            }

            public User build(){
                if(name == null || email == null){
                    throw new IllegalArgumentException("Name and Email is Mandatory");
                }
                return new User(this);
            }

        }
    }
}

