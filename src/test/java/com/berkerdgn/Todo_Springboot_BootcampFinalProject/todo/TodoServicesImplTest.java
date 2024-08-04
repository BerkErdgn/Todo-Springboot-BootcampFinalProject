// package com.berkerdgn.Todo_Springboot_BootcampFinalProject.todo;

// import org.junit.Test;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import
// com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.entity.TodoEntity;
// import
// com.berkerdgn.Todo_Springboot_BootcampFinalProject.data.repository.ITodoRepository;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import lombok.extern.log4j.Log4j2;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.assertj.core.api.Assertions.assertThat;

// @Log4j2
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @SpringBootTest
// public class TodoServicesImplTest implements ITestCrudDataBase {

// private TodoEntity todoEntity;

// private final ITodoRepository iTodoRepository;

// @Autowired
// public TodoServicesImplTest(ITodoRepository iTodoRepository) {
// this.iTodoRepository = iTodoRepository;
// }

// @BeforeAll
// static void getBeforeAllTodoAllMethod() {
// System.out.println("************Todo
// MethodlarındanhepsindenÖnce********************");
// log.info("************Todo MethodlarındanhepsindenÖnce********************");
// }

// @BeforeEach
// void getBeforeEachTodoAllMethod() {
// System.out.println("Todo Methodlarından Hemen Önce");
// log.info("Todo Methodlarından Hemen Önce");
// todoEntity = new TodoEntity();
// }

// @AfterEach
// void getAfterEachTodoAllMethod() {
// System.out.println("Todo Methodlarından Hemen Sonra");
// log.info("Todo Methodlarından Hemen Sonra");
// todoEntity = null;
// }

// @AfterAll
// static void getAfterAllTodoMethod() {
// System.out.println("******Todo Methodlarından hepsinden Sonra**********");
// log.info("******Todo Methodlarından hepsinden Sonra**********");
// }

// @Test
// @Override
// public void getFail() {
// // Assertions.fail("İsteyerek Hata Gönderdim");
// }

// @Test
// @Disabled("disabled")
// @Override
// public void getDisable() {
// Assertions.fail("Bilerek Bu Testi Kapattım");
// }

// @Test
// @RepeatedTest(1)
// @Order(1)
// @Tag(name = "create")
// @Override
// public void testCreateDatabase() {
// System.out.println("Todo Create");
// todoEntity.setTitle("Todo1");
// iTodoRepository.save(todoEntity);
// assertNotNull(iTodoRepository.findById(1).get());
// }

// @Test
// @Order(2)
// @Tag(name = "find")
// @Override
// public void testFindDatabase() {
// System.out.println("Todo Find");
// todoEntity = iTodoRepository.findById(1).get();
// assertEquals("Todo1", todoEntity.getTitle());
// }

// @Test
// @Order(3)
// @Tag(name = "List")
// @Override
// public void testListDatabase() {
// System.out.println("Todo List");
// Iterable<TodoEntity> list = iTodoRepository.findAll();
// assertThat(list).size().isGreaterThan(0);
// }

// @Test
// @Order(4)
// @Tag(name = "update") // Testleri mantıksal gruplar ayırmak için
// @Override
// public void testUpdateDatabase() {
// System.out.println("Todo update");
// todoEntity = iTodoRepository.findById(1).get();
// todoEntity.setTitle("Todo2");
// iTodoRepository.save(todoEntity);
// assertNotEquals("Todo1", iTodoRepository.findById(1).get().getTitle());
// }

// @Test
// @Order(5)
// @Tag(name = "delete") // Testleri mantıksal gruplar ayırmak için
// @Override
// public void testDeleteDatabase() {
// System.out.println("Todo delete");
// iTodoRepository.deleteById(1);
// assertThat(iTodoRepository.existsById(1)).isFalse();
// }

// }
