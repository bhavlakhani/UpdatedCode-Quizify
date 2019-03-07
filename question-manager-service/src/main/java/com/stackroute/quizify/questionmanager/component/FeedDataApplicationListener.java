package com.stackroute.quizify.questionmanager.component;

import com.stackroute.quizify.questionmanager.domain.*;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.service.QuestionService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
    private QuestionService questionService;
    private Category entertainment;
    private Topic movies;
    private Topic tvShows;
    private Genre drama;
    private Genre historical;
    private Genre action;
    private Genre thriller;
    private Genre comedy;
    private Genre anime;
    private Genre romance;
    private Genre scifi;
    private Genre documentary;
    private Genre talkshow;

    private Tag tag;
    private Question question;

    @Autowired
    public FeedDataApplicationListener(QuestionService questionService) {
        this.questionService = questionService;

        /**
         * Data For Category
         */
        this.entertainment = new Category();
        this.entertainment.setId(1);
        this.entertainment.setName("Entertainment");
        this.entertainment.setImageUrl("https://mitaanexpress.com/wp-content/uploads/2017/12/336fdcf7d540e4b430a890b63da159c9-1503648561-768x432.png");

        /**
         * Data For Topic
         */
        this.movies = new Topic();
        this.movies.setId(1);
        this.movies.setName("Movies");
        this.movies.setImageUrl("https://image.freepik.com/free-vector/cinema-logo_23-2147503279.jpg?1");

        this.tvShows = new Topic();
        this.tvShows.setId(2);
        this.tvShows.setName("TV Shows");
        this.tvShows.setImageUrl("https://tallypress.com/wp-content/uploads/2016/12/9-Popular-TV-shows-with-a-Malaysian-Flavour-1.jpg");

        /**
         * Data For Genre
         */
        this.documentary = new Genre();
        this.documentary.setId(1);
        this.documentary.setName("Documentary");
        this.documentary.setImageUrl("https://www.filmsite.org/images/documentary-genre.jpg");

        this.talkshow = new Genre();
        this.talkshow.setId(2);
        this.talkshow.setName("Reality & Talk Shows");
        this.talkshow.setImageUrl("https://cmkt-image-prd.global.ssl.fastly.net/0.1.0/ps/2661428/580/386/m1/fpnw/wm1/c1-.jpg?1494334679&s=b42e439d379c45825713ec1c3421f902");

        this.action = new Genre();
        this.action.setId(3);
        this.action.setName("Action");
        this.action.setImageUrl("http://bcheights.com/wp-content/uploads/2017/04/isabella-column-online.jpg");

        this.thriller = new Genre();
        this.thriller.setId(4);
        this.thriller.setName("Thriller");
        this.thriller.setImageUrl("https://image.slidesharecdn.com/thrillergenre-141005134450-conversion-gate01/95/thriller-genre-1-638.jpg?cb=1412606265");

        this.comedy = new Genre();
        this.comedy.setId(5);
        this.comedy.setName("Comedy");
        this.comedy.setImageUrl("http://lionhearttheatre.org/wp-content/uploads/2016/01/download-14.jpg");

        this.anime = new Genre();
        this.anime.setId(6);
        this.anime.setName("Anime");
        this.anime.setImageUrl("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/intermediary/f/7d3e695a-edba-4591-84d3-c8fa7896170a/d477hhk-235dfbf8-1fb0-497b-b8d0-49df393ece70.jpg");

        this.romance = new Genre();
        this.romance.setId(7);
        this.romance.setName("Romance");
        this.romance.setImageUrl("https://image.slidesharecdn.com/media-141105104952-conversion-gate02/95/romance-genre-powerpoint-1-638.jpg?cb=1415184629");

        this.drama = new Genre();
        this.drama.setId(8);
        this.drama.setName("Drama");
        this.drama.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMqK5BdSyRyCS8B5zTZ0AC3DYc0P4x2dRKMKLLbDUTGeOQPwDJ0g");

        this.scifi = new Genre();
        this.scifi.setId(9);
        this.scifi.setName("SciFi");
        this.scifi.setImageUrl("https://www.indiewire.com/wp-content/uploads/2013/12/sci-fi-genre.jpg");

        this.historical = new Genre();
        this.historical.setId(10);
        this.historical.setName("Historical");
        this.historical.setImageUrl("https://www.listchallenges.com/f/lists/87b065de-25d3-4020-800e-ba0434ecb908.jpg");

    };

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        File file = new File("./assets/MoviesBasicAll.xlsx");

        try
        {
            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(file));
            // Return first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();
            // Traversing over each row of XLSX file
            rowIterator.next();//Skipping 1st line
            int j=0;
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                List<String> options = null;
                question = new Question();
                question.setId(0);
                for (int i=1; cellIterator.hasNext(); i++)
                {
                    cell = cellIterator.next();
                    String cellType = "" + cell.getCellType();
                    switch (i)
                    {
                        case 1:
                            switch(cell.getStringCellValue())
                            {
                                case "Entertainment":
                                    this.question.setCategory(this.entertainment);
                                    break;
                                default:
                                    this.question.setCategory(null);
                            }
                            break;
                        case 2:
                            switch (cell.getStringCellValue())
                            {
                                case "Movies":
                                    this.question.setTopic(this.movies);
                                    break;
                                case "TV Shows":
                                    this.question.setTopic(this.tvShows);
                                    break;
                                default:
                                    this.question.setTopic(null);
                            }
                            break;
                        case 3:
                            switch (cell.getStringCellValue())
                            {
                                case "Drama":
                                    this.question.setGenre(this.drama);
                                    break;
                                case "Historical":
                                    this.question.setGenre(this.historical);
                                    break;
                                case "Action":
                                    this.question.setGenre(this.action);
                                    break;
                                case "Thriller":
                                    this.question.setGenre(this.thriller);
                                    break;
                                case "Comedy":
                                    this.question.setGenre(this.comedy);
                                    break;
                                case "Anime":
                                    this.question.setGenre(this.anime);
                                    break;
                                case "Romance":
                                    this.question.setGenre(this.romance);
                                    break;
                                case "SciFi":
                                    this.question.setGenre(this.scifi);
                                    break;
                                case "Documentary":
                                    this.question.setGenre(this.documentary);
                                    break;
                                case "Talkshow":
                                    this.question.setGenre(this.talkshow);
                                    break;
                                 default:
                                     this.question.setGenre(null);
                            }
                            break;
                        case 4:
                            switch (cell.getStringCellValue())
                            {
                                default:
                                    this.question.setTag(null);
                            }
                            break;
                        case 5:
                            this.question.setLevel(cell.getStringCellValue());
                            break;
                        case 6:
                            this.question.setType(cell.getStringCellValue());
                            break;
                        case 7:
                            this.question.setStatement(cell.getStringCellValue());
                            break;
                        case 8:
                            options = new ArrayList<>();
                        case 9:
                        case 10:
                        case 11:
                            if (cellType.equals("NUMERIC"))
                                options.add(""+cell.getNumericCellValue());
                            else
                                options.add(cell.getStringCellValue());
                            if (i==11)
                                this.question.setOptions(options);
                            break;
                        case 12:
                            if (cellType.equals("NUMERIC"))
                                this.question.setCorrectAnswer(""+cell.getNumericCellValue());
                            else
                                this.question.setCorrectAnswer(cell.getStringCellValue());
                            break;
                    }

                }

                this.questionService.addNewQuestion(this.question);
            }
        }
        catch (IOException | QuestionAlreadyExistsException e)
        {
            e.printStackTrace();
        }

    }
}
