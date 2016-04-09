package swip.ch16table.v2;


import swip.ch16table.domain.DomainBase;

import java.util.ArrayList;
import java.util.List;

public class TableContents<T> extends DomainBase {

    private final List<String> headers;
    private final List<T> rows;

    public TableContents(List<String> headers, List<T> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public String describeDiff(TableContents<T> other) {
        StringBuilder diff = new StringBuilder();
        if (!headers.equals(other.headers)) {
            diff.append("headers differ ")
                .append(headers).append(" vs ")
                .append(other.headers).append("\n");
        }

        diff.append(diff(this.rows, other.rows, "expected rows not found: "));
        diff.append(diff(other.rows, this.rows, "unexpected rows appeared: "));
        return diff.toString().trim();
    }

    private String diff(List<T> rows1, List<T> rows2, String s) {
        List<T> diff = new ArrayList<>(rows1);
        diff.removeAll(rows2);

        return diff.isEmpty() ? "" : s + diff + "\n";
    }
}