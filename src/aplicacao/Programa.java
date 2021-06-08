package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		System.out.println("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.println("Data do Check-in (dd/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do Check-Out (dd/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva. a data de check-out deve ser posterior a data de check-in");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva");
			System.out.println("Data do Check-in (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-Out (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva. a data de check-out deve ser posterior a data de check-in");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva. a data de check-out deve ser posterior a data de check-in");
			}

			else {
				reserva.updateDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}

			reserva.updateDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}

		sc.close();
	}

}
