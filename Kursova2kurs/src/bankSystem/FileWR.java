package bankSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.DepositAccount;
import controller.PaymentAccount;
import controller.UniversalAccount;
import dao.AccountInterface;
import entity.Account;
import enums.TypeAccount;

public class FileWR {

	static File fileInput;
	static FileReader fr;
	static BufferedReader br;

	static File fileOut;
	static FileWriter fw;
	static BufferedWriter bw;

	public static List<Account> read() throws IOException {
		fileInput = new File(".\\kursova.txt");
		if (!fileInput.exists()) {
			fileInput.createNewFile();
		}
		fr = new FileReader(fileInput);
		br = new BufferedReader(fr);

		List<Account> accounts = new ArrayList<Account>();

		String str = br.readLine();
		try {
			while (!str.equals("")) {
				String arr[] = new String[3];

				int c = -1;
				int count = 0;
				for (int i = 0; i < str.length(); i++) {
					if (str.substring(i, i + 1).equals("\\")) {
						arr[count] = str.substring(c + 1, i);
						c = i;
						count++;
					}
				}

				str = br.readLine();
				accounts.add(new Account(Long.parseLong(arr[0]), Double.parseDouble(arr[1]),
						TypeAccount.valueOf(arr[2]), chooseType(TypeAccount.valueOf(arr[2]))) {
				});
			}
		} catch (NullPointerException e) {

		}

		br.close();
		fr.close();

		return accounts;
	}

	public static void write(List<Account> accounts) throws IOException {

		fileOut = new File(".\\kursova.txt");
		if (!fileOut.exists())
			fileOut.createNewFile();
		fw = new FileWriter(fileOut);
		bw = new BufferedWriter(fw);

		for (int i = 0; i < accounts.size(); i++) {
			bw.write(accounts.get(i).getId() + "\\" + accounts.get(i).getBalance() + "\\"
					+ accounts.get(i).getTypeAccount() + "\\");
			bw.flush();
			bw.newLine();
		}

		bw.close();
		fw.close();
	}

	public static AccountInterface chooseType(TypeAccount ta) {
		if (ta == TypeAccount.DEPOSIT)
			return new DepositAccount();
		if (ta == TypeAccount.PAYMENT)
			return new PaymentAccount();
		if (ta == TypeAccount.UNIVERSAL)
			return new UniversalAccount();
		return null;
	}

}
