from fastapi import FastAPI
from pydantic import BaseModel
from agent_service import AgentService

app = FastAPI()
agent_service = AgentService()

class MessageRequest(BaseModel):
    agent_id: str
    message: str

@app.get("/")
def read_root():
    return {"message": "Hello World"}

@app.post("/chat")
def chat_with_agent(request: MessageRequest):
    response = agent_service.chat_with_agent(request.agent_id, request.message)
    return {
        "agent_id": request.agent_id,
        "message": request.message,
        "agent_response": response
    }

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8000)