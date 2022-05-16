public class Bus {

    /**
     * 포함 정보
     **/

    // 최대승객수
    static final int passengerLimit = 50;

    // 버스 번호
    private int busNumber;
    // 주유량
    private int gasAmount;
    //현재 속드
    private int speed;
    // 요금
    private int fare;

    // 현재 승객수
    private int passengerCount;

    // 상태 (운행, 차고지 행), enum Type (run:운행, garage: 차고지행, general: 택시 일반)
    private Status status;

    // 생성자,

    public Bus(int busNumber, int gasAmount) {

        this.passengerCount = 0;
        this.fare = 1250;

        // 버스 객체 생성 시, 번호는 고유값으로 생성되어야 합니다.
        this.busNumber = busNumber;

        this.gasAmount = gasAmount;

        this.speed = 0;

        // 버스 객체 생성 시, 최초 상태는 '운행' 상태가 됩니다.
        this.status = Status.RUN;
    }

    /**
     * 기능
     **/

    // 운행, 뭐지?

    // 버스 상태 변경 (객체 생성 시, 운행 상태)
    public void changeStatus(Status newStatus) {

        // 주유량이 떨어지거나, 운행을 종료할 때 '차고지행' 상태로 변경

        // 주유량이 10미만일 경우 '주유가 필요하다'는 메시지 출력

        if (gasAmount < 10) {
            System.out.println("주유가 필요합니다.");
        }
    }

    // 승객 탑승
    // 운행 중, '최대 승객 수' 이하까지 가능
    // 탑승 시, 현재 승객수 증가
    public void getIn(int newPassengerCount) {

        // 이런 것들만 보면 단숨에 모를 수도 있으니 메서드로 처리해주면 좋을 것 같음
        if (passengerCount + newPassengerCount > passengerLimit || Status.RUN != status) {
            return;
        }

        passengerCount += newPassengerCount;
    }

    // 속도 변경
    public void changeSpeed(int addedSpeed) {

        if (gasAmount < 10) {
            System.out.println("주유량을 확인해 주세요.");
            return;
        }

        speed += addedSpeed;
    }
}
