package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.PrintHtmlInterface;
import com.blyzniukd.hw.model.description.BoldDescription;
import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.description.LinkDescription;
import com.blyzniukd.hw.model.description.Period;

import java.util.Date;
import java.util.Objects;

public class Experience extends AbstractArraySection<Experience.ExperienceDescription> {

    public static final String HEADER = "Опыт работы";

    public Experience() {
        super(HEADER);
    }


    public void add(String company, String link,  Date start, Date finish, String position, String positionDesc) {
        ExperienceDescription record = new ExperienceDescription(new LinkDescription(company, link), new Period(start, finish), new BoldDescription(position), new Description(positionDesc));
        super.add(record);
    }

    class ExperienceDescription implements PrintHtmlInterface {
        private LinkDescription company;
        private Period period;
        private BoldDescription position;
        private Description description;
        private boolean printCompany = true;

        public ExperienceDescription(LinkDescription company, Period period, BoldDescription position, Description description1) {
            this.company = company;
            this.period = period;
            this.position = position;
            this.description = description1;
        }

        public boolean isPrintCompany() {
            return printCompany;
        }

        public void setPrintCompany(boolean printCompany) {
            this.printCompany = printCompany;
        }

        @Override
        public String printHtml() {
            return printCompany() + printInfo();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExperienceDescription that = (ExperienceDescription) o;
            return printCompany == that.printCompany &&
                    Objects.equals(company, that.company) &&
                    Objects.equals(period, that.period) &&
                    Objects.equals(position, that.position) &&
                    Objects.equals(description, that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(company, period, position, description, printCompany);
        }

        private String printCompany() {
            StringBuffer sb = new StringBuffer();
            if (printCompany) {
                sb.append("<tr><td colspan=\"2\"><h3>");
                sb.append(company.printHtml());
                sb.append("</h3></td></tr>");
            }
            return sb.toString();
        }

        private String printInfo() {
            StringBuffer sb = new StringBuffer();
            sb.append("<tr><td>");
            sb.append(period.printHtml());
            sb.append("</td><td>");
            sb.append(position.printHtml() + "<br>" + description.printHtml());
            sb.append("</td></tr>");
            return sb.toString();
        }
    }
}
