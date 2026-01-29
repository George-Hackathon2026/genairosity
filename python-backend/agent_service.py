from azure.ai.projects import AIProjectClient
from azure.identity import DefaultAzureCredential
from azure.ai.agents.models import ListSortOrder

class AgentService:
    def __init__(self):
        self.project = AIProjectClient(
            credential=DefaultAzureCredential(),
            endpoint="https://bh-uk-openai-genairosity.services.ai.azure.com/api/projects/BH-UK-OpenAI-GenAIrosity-project"
        )
    
    def chat_with_agent(self, agent_id: str, message: str) -> str:
        """
        Send a message to an agent and get a response.
        
        Args:
            agent_id: The ID of the agent to chat with
            message: The message to send to the agent
            
        Returns:
            The agent's response as a string
        """
        try:
            # Get the agent
            agent = self.project.agents.get_agent(agent_id)
            
            # Create a new thread
            thread = self.project.agents.threads.create()
            
            # Send the message
            self.project.agents.messages.create(
                thread_id=thread.id,
                role="user",
                content=message
            )
            
            # Run the agent and process the response
            run = self.project.agents.runs.create_and_process(
                thread_id=thread.id,
                agent_id=agent_id
            )
            
            # Get the response
            if run.status == "failed":
                return f"Error: Run failed - {run.last_error}"
            
            messages = self.project.agents.messages.list(
                thread_id=thread.id,
                order=ListSortOrder.ASCENDING
            )
            
            # Extract the last agent response
            for msg in messages:
                if msg.role == "assistant" and msg.text_messages:
                    return msg.text_messages[-1].text.value
            
            return "No response from agent"
            
        except Exception as e:
            return f"Error: {str(e)}"
