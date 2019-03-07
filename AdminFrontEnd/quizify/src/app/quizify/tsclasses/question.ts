import { Category } from './category';
import { Topic } from './topic';
import { Genre } from './genre';
import { Tag } from './tag';

export class Question {
    id: number;
    category: Category;
    topic: Topic;
    genre: Genre;
    tag: Tag;
    level: string;
    type: string;
    statement: string;
    options: string[];
    correctAnswer: string;
    playerAnswer:string;
}
