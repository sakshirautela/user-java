public class Spreadsheet {
    int[][] spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new int[26][rows];
    }

    int[] getidx(String cell) {
        int a = cell.charAt(0) - 'A';
        int b = Integer.parseInt(cell.substring(1))-1;
        return new int[]{a, b};
    }

    public void setCell(String cell, int value) {
        int[] idx = getidx(cell);
        spreadsheet[idx[0]][idx[1]] = value;
    }

    public void resetCell(String cell) {
        int[] idx = getidx(cell);
        spreadsheet[idx[0]][idx[1]] = 0;
    }

    public int getValue(String formula) {
        formula=formula.substring(1);
        String[] parts=formula.split("\\+");
        int result=0;
        for (int i = 0; i < parts.length; i++) {
            String s=parts[i];
            if(s.isEmpty()){
                continue;
            }else if (Character.isLetter(s.charAt(0))){
                int[] idx=getidx(s);
                result+=spreadsheet[idx[0]][idx[1]];
            }else{
                result+=Integer.parseInt(s);
            }
        }
        return result;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
/*class Spreadsheet {

    public Spreadsheet(int rows) {

    }

    Map<String, Integer> map = new HashMap<>();

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
        int io = formula.indexOf('+');
        String cell1 = formula.substring(1, io);
        String cell2 = formula.substring(io + 1);

        int val1;
        if (cell1.charAt(0) > '9') {
            val1 = map.getOrDefault(cell1, 0);
        } else {
            val1 = Integer.parseInt(cell1);
        }

        int val2;
        if (cell2.charAt(0) > '9') {
            val2 = map.getOrDefault(cell2, 0);
        } else {
            val2 = Integer.parseInt(cell2);
        }

        return val1 + val2;
    }
}


 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */