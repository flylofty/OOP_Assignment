public class Taxi {

    /**
     * 포함 정보
     */

    //택시 번호
    private int taxiNumber;
    // 주유량
    private int gasAmount;
    // 현재속도
    private int speed;
    // 기본 요금
    private int basicFare;
    // 거리당 요금
    private int farePerDistance;

    // 목적지
    private String destination;
    // 기본거리
    private int basicDistance;
    // 목적지까지 거리
    private int realDistance;
    // 상태(운행 중, 일반)
    private Status status;

    // 생성자
    public Taxi(int taxiNumber, int gasAmount, int speed, int basicFare, int farePerDistance, String destination, int basicDistance, int realDistance, Status status) {
        this.taxiNumber = taxiNumber;
        this.gasAmount = gasAmount;
        this.speed = speed;
        this.basicFare = basicFare;
        this.farePerDistance = farePerDistance;
        this.destination = destination;
        this.basicDistance = basicDistance;
        this.realDistance = realDistance;
        this.status = status;
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

        // 조금 더 고민...
        return "운행 시작!";
    }

    // 승객 탑승
    public String getIn() {

        // 일반 상태일 경우에만 탑승 가능
        if (Status.general != status) {
            return "탑승 불가";
        }

        // setter 혹은 승객 탑승 상태 변경 메서드를 이용하면 좋을 것 같음
        status = Status.RUN;
        return "승객 탑승";
    }

    // 속도 변경
    public void changeSpeed(int addedSpeed) {
        speed += addedSpeed;
    }
    
    // 거리당 요금 추가
    public int addFare() {
        if (realDistance > basicDistance) {
            return ((realDistance - basicDistance) * farePerDistance);
        }

        return 0;
    }

    // 요금 결제
    public String chargeFare() {
        return "택시 요금 : " + (basicDistance + addFare()) + "원 입니다.";
    }

}
