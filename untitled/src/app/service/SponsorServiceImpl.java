package app.service;

import app.model.Sponsor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SponsorServiceImpl implements SponsorService {

    private List<Sponsor> sponsorList = new ArrayList<>();

    public List<Sponsor> getSponsorList() {
        return sponsorList;
    }

    @Override
    public void readSponsors() {
        try {
            File data = new File("C:\\Users\\andrei\\Desktop\\ProiectPAO2\\src\\app\\data\\sponsors.txt");
            Scanner in = new Scanner(data);
            String line = in.nextLine();
            int noSponsors = Integer.parseInt(line);
            for (int i = 0; i < noSponsors; i++) {
                line = in.nextLine();
                String[] sponsorInfo = line.split(" ");
                String sponsorName = sponsorInfo[0];
                float sum = Float.parseFloat(sponsorInfo[1]);
                Sponsor sponsor = new Sponsor();
                sponsor.setName(sponsorName);
                sponsor.setSum(sum);
                sponsorList.add(sponsor);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at reading sponsors.");
        }
    }

    @Override
    public void showSponsors() {
        System.out.println("The sum each sponsor uses for the event: ");
        for (Sponsor sponsor : sponsorList) {
            System.out.println(sponsor);
        }
    }
}
