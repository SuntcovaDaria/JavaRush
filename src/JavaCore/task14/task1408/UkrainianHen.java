package JavaCore.task14.task1408;

public class UkrainianHen extends Hen implements Country{
    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    String getDescription() {
        return super.getDescription()+ " Моя страна - " + UKRAINE+ ". Я несу " + getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
