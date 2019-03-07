import { Category } from './category';
import { Genre } from './genre';
import { Topic } from './topic';
import { Tag } from './tag';
export class Question {
     id: number;
    category: Category;
    genre: Genre;
    topic: Topic;
    tag: Tag;
    level: string;
    type: string;
    statement: string;
    options: string[];
    correctAnswer: string;
    playerAnswer: string;
}