package karmanchik.demoexam.uijfx.controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import karmanchik.demoexam.dbservice.daos.AgentRepository;
import karmanchik.demoexam.dbservice.models.Agent;
import karmanchik.demoexam.uijfx.view.AgentTypeView;
import karmanchik.demoexam.uijfx.view.AgentView;
import karmanchik.demoexam.uijfx.view.SortView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MainUIController extends AbstractUIController {
    public static final int PAGE_COUNT = 10;

    private final AgentRepository agentRepository;
    private final ListView<AgentView> agentViews = new ListView<>();

    public Pagination pgAgents;
    public ComboBox<AgentTypeView> cbFilterAgentType;
    public ComboBox<SortView> cbSort;
    public TextField tfSearch;

    @Override
    protected void postShow() {

    }

    private void loadAgents(List<Agent> agents) {
        agentViews.getItems().clear();
        agentViews.getItems().addAll(
                agents.stream().map(agent -> new AgentView(agent).build())
                        .collect(Collectors.toList()));
    }

    @Override
    protected void preShow() {
        loadAgents(agentRepository.findAll());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pgAgents.setPageCount(PAGE_COUNT);
        pgAgents.setPageFactory(pageNumber -> {
            ListView<AgentView> views = new ListView<>();
            int page = pageNumber * PAGE_COUNT;
            for (int i = page; i < page + PAGE_COUNT; i++) {
                views.getItems().add(agentViews.getItems().get(i));
            }
            return views;
        });
    }
}
