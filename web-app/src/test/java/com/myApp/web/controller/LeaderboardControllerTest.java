package com.myApp.web.controller;

import com.myApp.web.service.LeaderboardScrapingService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class LeaderboardControllerTest {
    @Mock
    private Model model;

    @Mock
    private LeaderboardScrapingService leaderboardScrapingService;

    @InjectMocks
    private LeaderboardController leaderboardController;

/*    @Test
    public void testLeaderboard() throws IOException {
        Document document = Mockito.mock(Document.class);

        Elements elements = Mockito.mock(Elements.class);
        Element element1 = Mockito.mock(Element.class);

        Mockito.when(elements.select(Mockito.anyString())).thenReturn(elements);

        Element elementName = Mockito.mock(Element.class);
        Element elementRanking = Mockito.mock(Element.class);
        Element elementImgSrc = Mockito.mock(Element.class);

        Mockito.when(element1.selectFirst(Mockito.eq(".post-author-name"))).thenReturn(elementName);
        Mockito.when(element1.selectFirst(Mockito.eq(".master-players-world-stats"))).thenReturn(elementRanking);
        Mockito.when(element1.selectFirst(Mockito.eq(".post-author-thumbnail"))).thenReturn(elementImgSrc);

        Mockito.when(document.select(Mockito.eq("div.post-preview-list-component"))).thenReturn(elements);

        String result = leaderboardController.leaderboard(model);

        Mockito.verify(model).addAttribute(Mockito.eq("topPlayers"), Mockito.argThat(argument -> {
            List<ChessComPlayerDto> topPlayers = (List<ChessComPlayerDto>) argument;
            return topPlayers.size() == 1 &&
                    topPlayers.get(0).getUsername().equals("Magnus Carlsen") &&
                    topPlayers.get(0).getRating().equals("2853") &&
                    topPlayers.get(0).getPhotoUrl().equals("https://images.chesscomfiles.com/uploads/v1/master_player/3b0ddf4e-bd82-11e8-9421-af517c2ebfed.23bcb9e8.250x250o.fe16f88558e7.jpg");
        }));

        assertEquals("leaderboard", result);
    }

    @Test
    public void testLeaderboardLoading() throws IOException {
        Model model = new ExtendedModelMap();
        LeaderboardController controller = new LeaderboardController(leaderboardScrapingService);

        String viewName = controller.leaderboard(model);

        assertEquals("leaderboard", viewName);

        assertTrue(model.containsAttribute("topPlayers"));

        List<ChessComPlayerDto> topPlayers = (List<ChessComPlayerDto>) model.getAttribute("topPlayers");
        assertNotNull(topPlayers);
        assertFalse(topPlayers.isEmpty());
        assertTrue(topPlayers.stream().allMatch(player -> player instanceof ChessComPlayerDto));
    }*/
}
