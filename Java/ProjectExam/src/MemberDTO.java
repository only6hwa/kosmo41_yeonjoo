public class MemberDTO {
   
   
    private String id;
    private String pwd;
    private String name;
    private String tel;
    private String birth;
    private String intro;
 
    //이클립스팁 : Getter/Setter 만들기
    //             우클릭 -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
   
   
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
   
    //DTO 객체 확인
    //이클립스팁 : toString() 자동생성: 우클릭 -> source -> Generate toString->[OK]
    @Override
    public String toString() {
        return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name
                + ", tel=" + tel + ", birth=" + birth + ", intro=" + intro + "]";
    }
}
 