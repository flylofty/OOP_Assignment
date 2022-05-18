public class Taxi {

    /**
     * 포함 정보
     */

    // 기본 요금
    private static final int basicFare = 3800;

    // 거리당 요금
    private static final int farePerDistance = 100;

    // 기본거리
    private static final int basicDistance = 2000;

    //택시 번호
    private int taxiNumber;

    // 주유량
    private int gasAmount = 100;

    // 현재속도
    private int speed;

    // 목적지
    private String destination;

    // 목적지까지 거리
    private int realDistance;

    // 상태(운행 중, 일반)
    private Status status;

    // 생성자
    public Taxi(int taxiNumber) {
        // 고유값
        this.taxiNumber = taxiNumber;
    }

    /**
     * 기능
     */

    // 운행 시작
    public String startService() {
        // 운행 시작전 주유 상태를 체크하고 주유량이 10 이상이어야 운행 가능
        if (gasAmount < 10) {
            return "운행 불가";
        }

        return "운행 시작~!";
    }

    // 승객 탑승
    public String getIn(String destination) {

        // 일반 상태일 경우에만 탑승 가능
        if (Status.general != status) {
            return "탑승 불가";
        }

        // 운행
        status = Status.RUN;

        // 목적지 설정
        this.destination = destination;

        // 목적지까지 거리, 네비 검색
        this.realDistance = searchNavigation();

        return "승객 탑승 완료!";
    }

    private int searchNavigation() {
        // this.destination 를 통해 거리 찾음, 로직은 착한 사람만 보임
        return 10;
    }

    // 속도 변경
    public void changeSpeed(int addedSpeed) {

        int calculation = speed + addedSpeed;

        if (0 < calculation && calculation <= 100) {
            speed += addedSpeed;
            return;
        }

        speed = (calculation <= 0) ? 0 : 100;
    }
    
    // 거리당 요금 추가
    private int addFare() {
        if (realDistance > basicDistance) {
            return ((realDistance - basicDistance) * farePerDistance);
        }
        return 0;
    }

    // 요금 결제
    public String chargeFare() {
        return "택시 요금 : " + (basicFare + addFare()) + "원 입니다.";
    }
}
