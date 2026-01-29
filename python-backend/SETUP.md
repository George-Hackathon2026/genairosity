# Python Backend Setup Guide

## Prerequisites

- Python 3.8 or higher
- pyenv (optional but recommended for Python version management)

## Installation via pyenv

### 1. Install pyenv

**On Windows (using pyenv-win):**
```powershell
# Using Chocolatey
choco install pyenv-win

# Or using scoop
scoop install pyenv
```

**On macOS:**
```bash
brew install pyenv
```

**On Linux:**
```bash
curl https://pyenv.run | bash
```

### 2. Install Python using pyenv

```bash
pyenv install 3.11.0
pyenv local 3.11.0
```

### 3. Create Virtual Environment

```bash
python -m venv venv
```

### 4. Activate Virtual Environment

**On Windows:**
```powershell
.\venv\Scripts\Activate.ps1
```

**On macOS/Linux:**
```bash
source venv/bin/activate
```

### 5. Install Dependencies

```bash
pip install --upgrade pip
pip install -r requirements.txt
```

## Running the Server

```bash
python agent_server.py
```

The server will start at `http://127.0.0.1:8000`

## API Endpoints

- `GET /` - Health check
- `POST /chat` - Send a message to the agent

### Example Request

```bash
curl -X POST "http://127.0.0.1:8000/chat" \
  -H "Content-Type: application/json" \
  -d '{
    "agent_id": "agent1",
    "message": "Hello"
  }'
```

## Deactivate Virtual Environment

```bash
deactivate
```

## Troubleshooting

### pyenv not found on Windows
If you're using pyenv-win, ensure it's added to your PATH. Restart your terminal after installation.

### Permission denied on activation script (macOS/Linux)
```bash
chmod +x venv/bin/activate
```

### Module not found errors
Make sure your virtual environment is activated before running the server.
