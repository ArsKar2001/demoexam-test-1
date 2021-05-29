package karmanchik.demoexam.uijfx.view;

import karmanchik.demoexam.dbservice.models.AgentType;

public class AgentTypeView {
    public static final AgentTypeView ALL = new AgentTypeView(0, "Все типы");

    private AgentType agentType;
    private Integer id;
    private String title;

    public AgentTypeView(AgentType agentType) {
        this.agentType = agentType;
        this.id = agentType.getId();
        this.title = agentType.getTitle();
    }

    @Override
    public String toString() {
        return title;
    }

    public AgentTypeView(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public AgentType getAgentType() {
        return agentType;
    }

    public void setAgentType(AgentType agentType) {
        this.agentType = agentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
