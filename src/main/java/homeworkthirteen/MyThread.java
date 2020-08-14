package homeworkthirteen;

public class MyThread extends Thread {

    private float [] inArr;
    private float [] outArr;

    public MyThread(float [] arr) {
        inArr = arr;
        outArr = new float[arr.length];
    }

    @Override
    public void run() {
        for (int i = 0; i < inArr.length; i++) {
            outArr[i] = (float)(inArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }
    }

    public float[] getOutArr() {
        return outArr;
    }
}
