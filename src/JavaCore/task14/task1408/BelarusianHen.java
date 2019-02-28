package JavaCore.task14.task1408;

public class BelarusianHen extends Hen implements Country{

    @Override
    int getCountOfEggsPerMonth() {
        return 15;
    }

    @Override
    String getDescription() {
        return super.getDescription()+ " Моя страна - " + BELARUS+ ". Я несу "+ getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
