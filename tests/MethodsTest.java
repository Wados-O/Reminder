import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class MethodsTest {

    private TaskList taskList;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        taskList = new TaskList();
        taskList.addTask("Задача 1");
        taskList.addTask("Задача 2");
        taskList.addTask("Задача 3");
        scanner = new Scanner(System.in); // Может быть заменен на mock
    }


    void testRemoveValidIndex() {
        int numberTask = 2; // Удаляем вторую задачу
        taskList.remove(scanner, numberTask);

        ArrayList<String> remainingTasks = taskList.getTasks();
        assertEquals(2, remainingTasks.size());
        assertEquals("Задача 1", remainingTasks.get(0));
        assertEquals("Задача 3", remainingTasks.get(1));
    }


    void testRemoveInvalidIndex() {
        int numberTask = 4; // Несуществующий индекс
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.remove(scanner, numberTask));
    }
}

    private TaskList taskList;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        taskList = new TaskList();
        taskList.addTask("Задача 1");
        taskList.addTask("Задача 2");
        taskList.addTask("Задача 3");
        scanner = new Scanner(System.in); // Может быть заменен на mock
    }

    void testCorrectTaskValidIndex() {
        int numberTask = 2; // Изменяем вторую задачу
        String newTaskDescription = "Измененная задача";

        taskList.correctingTask(scanner, numberTask, newTaskDescription);

        ArrayList<String> updatedTasks = taskList.getTasks();
        assertEquals("Измененная задача", updatedTasks.get(numberTask - 1));
    }


    void testCorrectTaskInvalidIndex() {
        int numberTask = 4; // Несуществующий индекс
        String newTaskDescription = "Измененная задача";

        assertThrows(IndexOutOfBoundsException.class, () ->
                taskList.correctingTask(scanner, numberTask, newTaskDescription));
    }
}


private TaskList taskList;
private ByteArrayInputStream mockInput;
private ByteArrayOutputStream mockOutput;

@BeforeEach
    void setUp() {
            taskList = new TaskList();
            mockOutput = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutput)); // Перенаправляем вывод в mockOutput
            }


    void testAddTask() {
            // Создаем mock ввод для имитации пользовательского ввода
            String mockInputStr = "Название задачи\nКраткое описание\n01.01.2023\n";
            mockInput = new ByteArrayInputStream(mockInputStr.getBytes());
            System.setIn(mockInput); // Перенаправляем ввод в mockInput

            taskList.addTask(new Scanner(System.in)); // Передача Scanner в ваш метод

            // Проверка, что задача добавлена и вывод соответствует ожидаемому
            assertTrue(mockOutput.toString().contains("Задача добавлена."));
            }

    void testPrintTaskList() {
            // Подготовка данных для теста
            taskList.addTask("Задача 1");
            taskList.addTask("Задача 2");
            taskList.addTask("Задача 3");

            taskList.printTaskList();

            // Проверка, что вывод соответствует ожидаемому
            String expectedOutput = "│ 1     │Задача 1            │Задача 1                          │     Общее дело       │     Обычный            │01.01.2023          │      ❌       │\n" +
            "├───────┼────────────────────┼──────────────────────────────────┼───────────────────┼──────────────────────┼────────────────────┼─────────────┤\n" +
            "│ 2     │Задача 2            │Задача 2                          │     Общее дело       │     Обычный            │01.01.2023          │      ❌       │\n" +
            "├───────┼────────────────────┼──────────────────────────────────┼───────────────────┼──────────────────────┼────────────────────┼─────────────┤\n" +
            "│ 3     │Задача 3            │Задача 3                          │     Общее дело       │     Обычный            │01.01.2023          │      ❌       │\n";

            assertEquals(expectedOutput, mockOutput.toString());
            }
            }

private ByteArrayOutputStream mockOutput;

@BeforeEach
    void setUp() {
            mockOutput = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutput)); // Перенаправляем вывод в mockOutput
            }


    void testChoiceYesOrNo() {
            Choice.choiceYesOrNo();

            // Проверяем, что вывод соответствует ожидаемому
            String expectedOutput = "1. Да\n2. Нет\n\n";
            assertEquals(expectedOutput, mockOutput.toString());
            }
            }


private ByteArrayInputStream mockInput;

@BeforeEach
    void setUp() {
            // Подготовка ввода "1\n"
            String mockInputStr = "1\n";
            mockInput = new ByteArrayInputStream(mockInputStr.getBytes());
            System.setIn(mockInput); // Перенаправляем ввод в mockInput
            }


    void testAssigningValuePriority() {
            Scanner scanner = new Scanner(System.in);
            Priority priority = Priority.assigningValuePriority(scanner);

            // Проверяем, что возвращенное значение соответствует ожидаемому
            assertEquals(Priority.LOW, priority);
            }
            }



    private ByteArrayInputStream mockInput;

    @BeforeEach
    void setUp() {
        // Подготовка ввода "1\n"
        String mockInputStr = "1\n";
        mockInput = new ByteArrayInputStream(mockInputStr.getBytes());
        System.setIn(mockInput); // Перенаправляем ввод в mockInput
    }


    void testAssigningValueCategory() {
        Scanner scanner = new Scanner(System.in);
        Category category = Category.assigningValueCategory(scanner);

        // Проверяем, что возвращенное значение соответствует ожидаемому
        assertEquals(Category.WORK, category);
    }
}



