package kata5;

import javax.swing.JFrame;

public class Kata5 {

    public static void main(String[] args) {
        MockMainLoader loader = new MockMainLoader();
        HistogramBuilder <Mail> builder = new HistogramBuilder<> (loader.load());
        Histogram<String> histogram = builder.build(new AttributeExtractor<Mail, String>() {

            @Override
            public String extract(Mail entity) {
               return entity.getDomain();
            }
        });
        ChartHistogramViewer <String> viewer = new ChartHistogramViewer<> ();
        viewer.show(histogram);
    }
}
