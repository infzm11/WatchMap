package com.iflytek.sunflower;

import android.content.Context;
import com.iflytek.sunflower.util.i;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;

public class a {
    public List<List<String>> a(String str, Context context) {
        if (l.a((CharSequence) str)) {
            return null;
        }
        return b(str, context);
    }

    private List<List<String>> b(String str, Context context) {
        BufferedReader bufferedReader;
        if (l.a((CharSequence) str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            j.c("AnrTraceParser", str + " not exists");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    arrayList3.add(readLine);
                    if (compile.matcher(readLine).matches()) {
                        arrayList2.add(arrayList3);
                        arrayList3 = new ArrayList();
                    }
                }
                int size = arrayList2.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        List list = (List) arrayList2.get(i);
                        ListIterator listIterator = list.listIterator();
                        while (true) {
                            if (listIterator.hasNext()) {
                                if (listIterator.next().toString().contains(context.getPackageName())) {
                                    arrayList.add(list);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                i.a((Reader) bufferedReader);
                i.a((Reader) bufferedReader);
                return arrayList;
            } catch (Exception e) {
                e = e;
                try {
                    j.d("AnrTraceParser", "parser error", e);
                    i.a((Reader) bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    i.a((Reader) bufferedReader);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
            j.d("AnrTraceParser", "parser error", e);
            i.a((Reader) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            i.a((Reader) bufferedReader);
            throw th;
        }
    }
}
