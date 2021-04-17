package paczkaTestowa;

import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        new LogMain().doSth();

    }


    public void doSth() {
        Employee employee = new Employee();
        employee.setEmail("test@email");

        logger.error("error");
        logger.warn("warning");
        logger.info("info {}, {}", employee, "jakis teks");
        logger.debug("debug");
        logger.trace("trace");

    }
}
