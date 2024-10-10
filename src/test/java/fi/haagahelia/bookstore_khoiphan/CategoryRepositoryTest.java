package fi.haagahelia.bookstore_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.bookstore_khoiphan.domain.Category;
import fi.haagahelia.bookstore_khoiphan.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewCategoryTest() throws Exception{
        
        Category cate1 = new Category("Manga");

        categoryRepository.save(cate1);

        assertThat(cate1.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategoryTest() throws Exception {
        Category cate1 = new Category("Manga");

        categoryRepository.save(cate1);

        assertThat(cate1.getCategoryid()).isNotNull();

        Long id = cate1.getCategoryid();

        categoryRepository.deleteById(id);

        List<Category> cates = (List<Category>) categoryRepository.findAll();

        assertThat(cates).hasSize(4);
    }

    @Test
    public void searchCategoryTest() throws Exception{
        Category cate1 = new Category("Manga");

        categoryRepository.save(cate1);

        assertThat(cate1.getCategoryid()).isNotNull();

        Category cate = categoryRepository.findByName("Manga");

        assertThat(cate).isNotNull();
        assertThat(cate.getName()).isEqualTo("Manga");

    }

}
