package kr.or.ddit.vo;

/**
 * DB테이블에 있는 컬럼을 기준으로 데이터를 객체화할 클래스
 *
 * DB테이블의 '컬럼명'이 이 클래스의 '멤버변수명'이 된다.
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 *
 * @author
 */
public class MemberVO {
   private String mem_id;
   private String meme_pass;
   private String mem_name;
   private String mem_tel;
   private String mem_addr;

   // VO클래스에서 별도의 생성자를 만들때에는 기본 생성자도 반드시 같이 만들어야한다

    public MemberVO(String mem_id, String meme_pass, String mem_name, String mem_tel, String mem_addr) {
        this.mem_id = mem_id;
        this.meme_pass = meme_pass;
        this.mem_name = mem_name;
        this.mem_tel = mem_tel;
        this.mem_addr = mem_addr;
    }

    public MemberVO() {

    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMeme_pass() {
        return meme_pass;
    }

    public void setMeme_pass(String meme_pass) {
        this.meme_pass = meme_pass;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_tel() {
        return mem_tel;
    }

    public void setMem_tel(String mem_tel) {
        this.mem_tel = mem_tel;
    }

    public String getMem_addr() {
        return mem_addr;
    }

    public void setMem_addr(String mem_addr) {
        this.mem_addr = mem_addr;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "mem_id='" + mem_id + '\'' +
                ", meme_pass='" + meme_pass + '\'' +
                ", mem_name='" + mem_name + '\'' +
                ", mem_tel='" + mem_tel + '\'' +
                ", mem_addr='" + mem_addr + '\'' +
                '}';
    }
}
