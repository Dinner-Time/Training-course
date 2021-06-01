package 상속;

public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPhone dmbCellPhone = new DmbCellPhone("galaxy", "black", 10);
//		DmbCellPhone phone = new DmbCellPhone();

		System.out.printf("model:%s color:%s channel:%d\n", dmbCellPhone.model, dmbCellPhone.color,
				dmbCellPhone.channel);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannel(30);
		dmbCellPhone.turnOffDmb();
		dmbCellPhone.powerOff();

	}

}
