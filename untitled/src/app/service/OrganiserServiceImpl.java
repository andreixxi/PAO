package app.service;

import app.model.Organiser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrganiserServiceImpl implements OrganiserService {

    private List<Organiser> organiserList = new ArrayList<>();

    public List<Organiser> getOrganiserList() {
        return organiserList;
    }

    @Override
    public void readOrganisers() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\organisers.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noOrganisers = Integer.parseInt(line);
            for (int i = 0; i < noOrganisers; i++) {
                line = in.nextLine();
                String[] organiserInfo = line.split(" ");
                String organiserName = organiserInfo[0];
                float sum = Float.parseFloat(organiserInfo[1]);
                Organiser organiser = new Organiser();
                organiser.setName(organiserName);
                organiser.setEventBudget(sum);
                organiserList.add(organiser);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading organisers' info.");
        }
    }

    @Override
    public void showOrganisers() {
        System.out.println("The sum each organiser needs for the event: ");
        for (Organiser organiser : organiserList) {
            System.out.println(organiser);
        }
    }
}
