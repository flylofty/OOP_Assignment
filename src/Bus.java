public class Bus {

    /**
     * 포함 정보
     **/

    // 요금
    private static final int fare = 1200;

    // 최대승객수
    private static final int passengerLimit = 50;

    // 버스 번호
    private int busNumber;

    // 주유량
    private int gasAmount = 100;

    //현재 속드
    private int speed;

    // 현재 승객수
    private int passengerCount;

    // 상태 (운행, 차고지 행), enum Type (run:운행, garage: 차고지행, general: 택시 일반)
    private Status status;

    public Bus(int busNumber) {
        // 버스 객체 생성 시, 번호는 고유값으로 생성되어야 합니다. UUID
        this.busNumber = busNumber;

        // 버스 객체 생성 시, 최초 상태는 '운행' 상태가 됩니다.
        this.status = Status.RUN;
    }

    /**
     * 기능
     **/

    // 운행...

    // 버스 상태 변경 (객체 생성 시, 운행 상태)
    public void changeStatus(Status newStatus) {

        // 주유량이 떨어지거나, 운행을 종료할 때 '차고지행' 상태로 변경
        if (gasAmount == 0 || newStatus == Status.garage) {
            this.status = Status.garage;
            return;
        }

        // 주유량이 10미만일 경우 '주유가 필요하다'는 메시지 출력
        if (gasAmount < 10) {
            System.out.println("주유가 필요합니다.");
        }

        this.status = newStatus;
    }

    // 승객 탑승
    // 운행 중, '최대 승객 수' 이하까지 가능
    // 탑승 시, 현재 승객수 증가
    public void getIn(int newPassengerCount) {

        if (Status.RUN != status) {
            System.out.println("운행 중인 버스가 아닙니다.");
            return;
        }

        int addedCount = passengerCount + newPassengerCount;

        if (addedCount > passengerLimit) {
            return;
        }

        passengerCount = addedCount;
    }

    // 속도 변경
    public void changeSpeed(int addedSpeed) {

        if (gasAmount < 10) {
            System.out.println("주유량을 확인해 주세요.");
        }

        int calculation = speed + addedSpeed;

        if (0 < calculation && calculation <= 100) {
            speed += addedSpeed;
            return;
        }

        speed = (calculation <= 0) ? 0 : 100;
    }
}
