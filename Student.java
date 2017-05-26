

public class Student {
 
 @Override
 public String toString() {
  return "Student [name=" + name + ", phone=" + phone + ", address="
    + address + ", email=" + email + ", other=" + other + "]";
 }
 //private int id;
 private String name;
 private String phone;
 private String address;
 private String email;
 private String other;
 
 public Student(){
  
 }
 public Student(String name, String phone, String address, String email,
   String other) {
  super();
  this.name = name;
  this.phone = phone;
  this.address = address;
  this.email = email;
  this.other = other;
 }
 /*public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }*/
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getPhone() {
  return phone;
 }
 public void setPhone(String phone) {
  this.phone = phone;
 }
 public String getAddress() {
  return address;
 }
 public void setAddress(String address) {
  this.address = address;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getOther() {
  return other;
 }
 public void setOther(String other) {
  this.other = other;
 }
 
 

}
