package exams.firstfitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class FitnessClub {
    public Pass[] GYM = new Pass[20];
    public Pass[] SWIMMING_POOL = new Pass[20];
    public Pass[] GROUP_TRAINING = new Pass[20];

    public void clientIsArrived(Pass pass) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("в H ч. и mm мин.");
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        ZoneType requiredZone;
        PassType clientPassType = pass.getPassType();
        String timeToStr = formatter.format(currentTime);

        if (pass.getPassType().equals(PassType.FULL)) {
            int i = (int) (Math.random() * 3);
            requiredZone = pass.getPassType().getZoneType()[i];
        } else {
            int i = (int) (Math.random() * 2);
            requiredZone = pass.getPassType().getZoneType()[i];
        }

        System.out.println("Клиент " + pass.getName() + " " + pass.getSurname() + " хочет попасть в " + requiredZone + ".");
        System.out.println("Тип абанемента: " + clientPassType + ", дата посещния " + currentDate + " " + timeToStr);
        if (pass.getRegistrationDate().isAfter(currentDate) || pass.getExpirationDate().isBefore(currentDate)) {
            System.out.println("Абонемент " + pass.getName() + " " + pass.getSurname() + " истек" + pass.getExpirationDate() + ".");
            return;
        }

        switch (clientPassType) {
            case SINGLE:
                if (currentTime.isBefore(PassType.SINGLE.getStartTime()) || currentTime.isAfter(PassType.SINGLE.getEndTime())) {
                    System.out.println(pass.getName() + " " + pass.getSurname() + "пришел не вовремя.");
                } break;
            case DAY:
                if (currentTime.isBefore(PassType.DAY.getStartTime()) || currentTime.isAfter(PassType.DAY.getEndTime())) {
                    System.out.println(pass.getName() + pass.getSurname() + "пришел не вовремя.");
                } break;
            case FULL:
                if (currentTime.isBefore(PassType.FULL.getStartTime()) || currentTime.isAfter(PassType.FULL.getEndTime())) {
                    System.out.println(pass.getName() + pass.getSurname() + "пришел не вовремя.");
                } break;
        }

        switch (requiredZone) {
            case GYM:
                for (int i = 0; i < 20; i++) {
                    if (GYM[i] == null) {
                        GYM[i] = pass;
                        System.out.println(pass.getName() + " вошел в " + requiredZone + "\n");
                        break;
                    } else if (GYM[GYM.length - 1] != null) {
                        System.out.println("Свободных мест нет\n");
                        break;
                    }
                } break;
            case SWIMMING_POOL:
                for (int i = 0; i < 20; i++) {
                    if (SWIMMING_POOL[i] == null) {
                        SWIMMING_POOL[i] = pass;
                        System.out.println(pass.getName() + " вошел в " + requiredZone + "\n");
                        break;
                    } else if (SWIMMING_POOL[SWIMMING_POOL.length - 1] != null) {
                        System.out.println("Свободных мест нет\n");
                        break;
                    }
                } break;
            case GROUP_TRAINING:
                for (int i = 0; i < 20; i++) {
                    if (GROUP_TRAINING[i] == null) {
                        GROUP_TRAINING[i] = pass;
                        System.out.println(pass.getName() + " вошел в " + requiredZone + "\n");
                        break;
                    } else if (GROUP_TRAINING[GROUP_TRAINING.length - 1] != null) {
                        System.out.println("Свободных мест нет\n");
                        break;
                    }
                } break;
        }

    }

    public void info() {
        System.out.println("\nПосетители тренажерного зала: ");
        for (int i = 0; i < 20; i++) {
            if (this.GYM[0] == null) {
                System.out.println("В тренажерном зале никого нет");
                break;
            }
            if (this.GYM[i] != null )
            System.out.println(this.GYM[i].getName() + " " + this.GYM[i].getSurname());
        }
        System.out.println("\nПосетители бассейна: ");
        for (int i = 0; i < 20; i++) {
            if (this.SWIMMING_POOL[0] == null) {
                System.out.println("В бассейне никого нет");
                break;
            }
            if (this.SWIMMING_POOL[i] != null )
                System.out.println(this.SWIMMING_POOL[i].getName() + " " + this.SWIMMING_POOL[i].getSurname());
        }
        System.out.println("\nПосетители групповых занятий: ");
        for (int i = 0; i < 20; i++) {
            if (this.GROUP_TRAINING[0] == null) {
                System.out.println("На групповых занятиях никого нет");
                break;
            }
            if (this.GROUP_TRAINING[i] != null )
                System.out.println(this.GROUP_TRAINING[i].getName() + " " + this.GROUP_TRAINING[i].getSurname());
        }

    }

    public void closed() {
        for (int i = 0; i < 20; i++) {
            if (this.GYM[i] != null) {
                this.GYM[i] = null;
            }
            if (this.SWIMMING_POOL[i] != null) {
                this.SWIMMING_POOL[i] = null;
            }
            if (this.GROUP_TRAINING[i] != null) {
                this.GROUP_TRAINING[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                "GYM=" + Arrays.toString(GYM) + "\n" +
                ", SWIMMING_POOL=" + Arrays.toString(SWIMMING_POOL) + "\n" +
                ", GROUP_TRAINING=" + Arrays.toString(GROUP_TRAINING) +
                '}';
    }
}
