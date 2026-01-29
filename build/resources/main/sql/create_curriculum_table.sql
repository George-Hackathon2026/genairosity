%sql
--Curriculum table: represents a 12-week program
CREATE TABLE hackathon_teams.genairosity.curriculum (
                                                        curriculum_id BIGINT GENERATED ALWAYS AS IDENTITY COMMENT 'Unique identifier for each curriculum',
                                                        curriculum_name STRING COMMENT 'Name of the curriculum program',
                                                        description STRING COMMENT 'Description of the curriculum content and objectives',
                                                        target_qualification STRING COMMENT 'The target qualification of this curriculum, if any',
                                                        duration_weeks INT COMMENT 'Total duration in weeks (typically 12)',
                                                        created_at TIMESTAMP COMMENT 'When the curriculum was created',
                                                        updated_at TIMESTAMP COMMENT 'Last update timestamp',
                                                        is_active BOOLEAN COMMENT 'Whether this curriculum is currently active',
                                                        data_source STRING COMMENT 'Source of the curriculum data'
) COMMENT 'Represents a structured curriculum program spanning multiple weeks';

-- Bridge table: links curriculum to lesson plans with scheduling
CREATE TABLE hackathon_teams.genairosity.bridge_curriculum_lesson_plan (
                                                                           curriculum_id INT COMMENT 'Reference to curriculum table',
                                                                           lesson_plan_id INT COMMENT 'Reference to lesson_plan table',
                                                                           week_number INT COMMENT 'Week number in the curriculum (1-12)',
                                                                           day_number INT COMMENT 'Day number within the week (1-7)',
                                                                           session_time STRING COMMENT 'Time of day for the session (e.g., "14:30")',
                                                                           created_at TIMESTAMP COMMENT 'When this mapping was created',
                                                                           updated_at TIMESTAMP COMMENT 'Last update timestamp'
) COMMENT 'Bridge table linking curricula to lesson plans with weekly schedule';