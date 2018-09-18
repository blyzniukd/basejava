package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.description.LinkDescription;
import com.blyzniukd.hw.model.description.Period;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Experience extends AbstractArraySection<Experience.CompanyDescription> {

    public static final String HEADER = "Опыт работы";

    public Experience() {
        super(HEADER);
    }


    public void add(String company, String link, LocalDate start, LocalDate finish, String position, String positionDesc) {
        CompanyDescription record = new CompanyDescription(new LinkDescription(company, link), new Period(start, finish), new Description(position), new Description(positionDesc));
        super.add(record);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
                sb.append("Experience{")
                .append("Name=").append(HEADER).append(System.getProperty("line.separator"))
                .append("list=").append(System.getProperty("line.separator"));
                getList().forEach((e)->{sb.append(e+System.getProperty("line.separator"));});
                sb.append('}');
                return sb.toString();
    }

    class CompanyDescription {
        private LinkDescription company;
        private Period period;
        private Description position;
        private Description description;
        //Если группировать по компании, то не нужно лишний раз печатать назавание
        private boolean printCompany = true;

        public CompanyDescription(LinkDescription company, Period period, Description position, Description description1) {
            this.company= company;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompanyDescription that = (CompanyDescription) o;
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

        @Override
        public String toString() {
            return new StringBuilder().append("CompanyDescription{")
                            .append((isPrintCompany()) ? ("company=" + company) : "")
                            .append(", period=").append(period)
                            .append(", position=").append(position)
                            .append(", description=").append(description)
                            .append(", printCompany=").append(printCompany)
                            .append('}').toString();
        }
    }
}
