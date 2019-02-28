package JavaCore.task14.task1408;

public class RussianHen extends Hen implements Country {

    @Override
    int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+ RUSSIA+". Я несу "+ getCountOfEggsPerMonth()+ "яиц в месяц.";
    }
}
